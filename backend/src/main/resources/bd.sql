CREATE TABLE users(
	user_id UUID PRIMARY KEY,
	display_name VARCHAR(255),
	user_name VARCHAR(255) NOT NULL UNIQUE,
	password VARCHAR(255) NOT NULL,
	avatar VARCHAR(255) DEFAULT NULL,
	role TINYINT NOT NULL DEFAULT 0, -- 0 = user, 1 = admin
	status TINYINT NOT NULL DEFAULT 1, -- 0 = inactivo, 1 = activo
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP()
);

CREATE TABLE posts(
	post_id BIGINT AUTO_INCREMENT PRIMARY KEY,
	author_id UUID NOT NULL,
	title VARCHAR(255) NOT NULL,
	body TEXT,
	hashtags TEXT,
	status TINYINT NOT NULL DEFAULT 0, -- 0 = draft, 1 = published, 2 = archived
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
	published_at TIMESTAMP NULL,
	FOREIGN KEY (author_id) REFERENCES users(user_id)
);

CREATE TABLE media(
	media_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    post_id BIGINT NOT NULL,
    media_type TINYINT NOT NULL DEFAULT 0, -- 0 = image, 1 = video
    url VARCHAR(512) NOT NULL,
    position BIGINT NOT NULL DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    FOREIGN KEY (post_id) REFERENCES posts(post_id) ON DELETE CASCADE
);

CREATE TABLE publications(
	publication_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    post_id BIGINT NOT NULL,
    platform TINYINT NOT NULL, -- 0 = web, 1 = instagram, 2 = tiktok, 3 = twitter
    external_id VARCHAR(255) DEFAULT NULL,
    status TINYINT NOT NULL DEFAULT 0, -- 0 = pending, 1 = published, 2 = failed
    published_at TIMESTAMP NULL,
    error_message TEXT DEFAULT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    UNIQUE (post_id, platform),
    FOREIGN KEY (post_id) REFERENCES posts(post_id) ON DELETE CASCADE
);

CREATE INDEX idx_posts_author ON posts(author_id);
CREATE INDEX idx_posts_status_published ON posts(status, published_at);
CREATE INDEX idx_media_post_position ON media(post_id, position);
CREATE INDEX idx_publications_status ON publications(status);