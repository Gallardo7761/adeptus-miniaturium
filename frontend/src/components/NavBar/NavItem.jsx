import { HashLink } from "react-router-hash-link/dist/react-router-hash-link.cjs.production";

const NavItem = ({ item, index, onClick, onCloseNav }) => {
  let borderClass = `${index === 0 ? "border-left border-right" : "border-right"}`;

  const handleClick = (e) => {
    if (onClick) {
      e.preventDefault();
      onClick();
    } else if (item.href === "#") {
      e.preventDefault();
    }

    if (onCloseNav) {
      onCloseNav();
    }
  };

  return (
    <li className={`mx-0 ${borderClass}`}>
      {onClick || item.href === "#" ? (
        <button 
          onClick={handleClick} 
          className="nav-button"
          style={{ cursor: "pointer" }}
        >
          {item.label}
        </button>
      ) : (
        <HashLink smooth to={item.href} className="nav-link-custom" onClick={handleClick}>
          {item.label}
        </HashLink>
      )}
    </li>
  );
};

export default NavItem;