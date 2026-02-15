import { Link } from "react-router-dom";

const NavItem = ({ item, index, total }) => {
  let borderClass = `${index === 0 ? "border-left border-right" : "border-right"}`;

  return (
    <li className={`mx-0 ${borderClass}`}>
      <Link to={item.href} className="nav-link-custom">
        {item.label}
      </Link>
    </li>
  );
};

export default NavItem;