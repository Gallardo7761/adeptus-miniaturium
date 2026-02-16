import { useTranslation } from "react-i18next";
import NavItem from '@/components/NavBar/NavItem';

const LanguageButton = ({ as = "button", index = null }) => {
  const { i18n } = useTranslation();

  const toggleLanguage = () => {
    console.log(i18n.language);
    const nextLang = i18n.language === "es" ? "en" : "es";
    i18n.changeLanguage(nextLang);
  };

  if (as === "navitem") {
    return (
      <NavItem 
        item={{
          label: i18n.language === "es" ? "🇪🇸" : "🇺🇸",
          href: "#"
        }}
        index={index}
        onClick={toggleLanguage}
      />
    );
  }

  return (
    <button onClick={toggleLanguage} className="btn-imperial">
      {i18n.language === "es" ? "🇪🇸" : "🇺🇸"}
    </button>
  );
};

export default LanguageButton;