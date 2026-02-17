import { useEffect, useState } from "react";

const images = [
  "/images/mini_1.jpeg",
  "/images/mini_2.jpeg",
  "/images/mini_3.jpeg",
  "/images/mini_4.jpeg",
  "/images/mini_5.jpeg",
];

const TOTAL_FRAMES = images.length;

const ScrollBackgroundSpin = () => {
  const [frame, setFrame] = useState(0);

  useEffect(() => {
    const handleScroll = () => {
      const scrollTop = window.scrollY;
      const maxScroll = document.body.scrollHeight - window.innerHeight;
      const progress = scrollTop / maxScroll;

      const currentFrame = Math.floor(progress * TOTAL_FRAMES);
      setFrame(Math.min(currentFrame, TOTAL_FRAMES - 1));
    };

    window.addEventListener("scroll", handleScroll);
    return () => window.removeEventListener("scroll", handleScroll);
  }, []);

  return (
    <div className="spin-background">
      <img src={images[frame]} alt="Miniatura fondo" />
    </div>
  );
};

export default ScrollBackgroundSpin;