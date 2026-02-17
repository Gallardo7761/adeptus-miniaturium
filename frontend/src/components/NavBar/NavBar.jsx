import { useWindowWidth } from '@/hooks/useWindowWidth';
import NavBarDesktop from '@/components/NavBar/desktop/NavBarDesktop';
import NavBarMobile from '@/components/NavBar/mobile/NavBarMobile';
import { useTranslation } from 'react-i18next';

const NavBar = () => {
  const { t } = useTranslation();
  const width = useWindowWidth();
  const navItems = [
    { label: t("nav.inicio.label"), href: `/#${t("nav.inicio.href")}` },
    { label: t("nav.muestras.label"), href: `/#${t("nav.muestras.href")}` },
    { label: t("nav.pedidos.label"), href: `/#${t("nav.pedidos.href")}` },
    { label: t("nav.sobre.label"), href: `/#${t("nav.sobre.href")}` },
    { label: t("nav.login.label"), href: `/${t("nav.login.href")}` }
  ];

  return width > 991.98 ? (
    <nav className="nav-container p-0">
      <NavBarDesktop navItems={navItems} />
    </nav>
  ) : (
    <NavBarMobile navItems={navItems} />
  );
};

export default NavBar;