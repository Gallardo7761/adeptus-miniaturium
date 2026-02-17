import NavItem from '@/components/NavBar/NavItem';
import LanguageButton from '@/components/LanguageButton';

import '@/css/NavBar.css';

const NavBarDesktop = ({ navItems }) => {
  const centerItems = navItems.slice(0, navItems.length - 1);
  const rightItems = navItems.slice(-1);

  return (
    <ul className="d-flex align-items-center list-unstyled m-0 w-100 justify-content-center position-relative">
      <li className="position-absolute start-0 d-flex">
        <LanguageButton as='navitem' index={0} total={rightItems.length + 1} />
      </li>
      
      {centerItems.map((item, index) => (
        <NavItem key={index} item={item} index={index} total={centerItems.length} />
      ))}

      <li className="position-absolute end-0 d-flex">
        {rightItems.map((item, index) => (
          <NavItem key={index} item={item} index={index} total={rightItems.length} />
        ))}
      </li>

    </ul>
  );
};

export default NavBarDesktop;