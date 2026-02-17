import '@/css/Header.css';
import { useTranslation } from 'react-i18next';

const Header = () => {
  const { t } = useTranslation();

  return (
    <header className="py-5 text-center position-relative">
      <h1 className="mb-2">Adeptus Miniaturium</h1>
      <p className="m-0">{t("header.subtitle")}</p>
    </header>
  );
};

export default Header;