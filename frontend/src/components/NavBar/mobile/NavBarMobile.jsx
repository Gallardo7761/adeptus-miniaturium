import { useState } from 'react';
import NavItem from '@/components/NavBar/NavItem';
import LanguageButton from '@/components/LanguageButton';
import '@/css/NavBarMobile.css';

const NavBarMobile = ({ navItems }) => {
  const [open, setOpen] = useState(false);

  const handleClose = () => {
    setOpen(false);
  }

  return (
    <nav className="nav-container d-lg-none">
      <div className="nav-mobile-header d-flex justify-content-between align-items-center">
        {/* Por si algun dia se pone
        <div className="nav-mobile-brand"></div>
        */}
        <button 
          className={`nav-mobile-toggle ms-2 ${open ? 'open' : ''}`}
          onClick={() => setOpen(!open)}
        >
          <span></span>
          <span></span>
          <span></span>
        </button>
      </div>

      {open && (
        <ul className="nav-list-mobile d-flex flex-column align-items-center list-unstyled m-0 w-100">
          {navItems.map((item, index) => (
            <NavItem key={index} item={item} onCloseNav={handleClose} />
          ))}
          <LanguageButton as="navitem" />
        </ul>
      )}
    </nav>
  );
};

export default NavBarMobile;