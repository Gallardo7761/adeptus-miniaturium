import '@/css/NavBar.css';
import NavItem from './NavItem';
import LanguageButton from '../LanguageButton';
import { useTranslation } from 'react-i18next';

const NavBar = () => {
  const { t } = useTranslation();

  const navItems = [
    { label: t("nav.inicio.label"), href: `/#${t("nav.inicio.href")}` },
    { label: t("nav.muestras.label"), href: `/#${t("nav.muestras.href")}` },
    { label: t("nav.pedidos.label"), href: `/#${t("nav.pedidos.href")}` },
    { label: t("nav.sobre.label"), href: `/#${t("nav.sobre.href")}` },
    { label: t("nav.login.label"), href: `/${t("nav.login.href")}` }
  ];

  const centerItems = navItems.slice(0, navItems.length - 1);
  const rightItems = navItems.slice(-1);

  return (
    <nav className="nav-container">
      <ul className="d-flex align-items-center list-unstyled m-0 w-100 justify-content-center position-relative">

        {centerItems.map((item, index) => (
          <NavItem key={index} item={item} index={index} total={centerItems.length} />
        ))}

        <li className="position-absolute end-0 d-flex">
          <LanguageButton as='navitem' index={0} total={rightItems.length + 1} />
          {rightItems.map((item, index) => (
            <NavItem key={index} item={item} index={index + 1} total={rightItems.length + 1} />
          ))}
        </li>

      </ul>
    </nav>
  );
};

export default NavBar;