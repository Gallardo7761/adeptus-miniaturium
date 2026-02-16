import ContentWrapper from "@/components/ContentWrapper";
import CustomContainer from "@/components/CustomContainer";
import ScrollBackgroundSpin from "@/components/Home/ScrollBackgroundSpin";
import TechCard from "@/components/TechCard";
import { HashLink } from "react-router-hash-link/dist/react-router-hash-link.cjs.production";
import { useTranslation } from "react-i18next";

const Home = () => {
  const { t } = useTranslation();
  const muestras = t("home.muestras", { returnObjects: true });

  return (
    <ContentWrapper>
      <ScrollBackgroundSpin />
      <CustomContainer>

        <section id={t("nav.inicio.href")} className="container py-5">
          <h2 className="section-title text-center mb-5">{t("home.inicio_title")}</h2>
          <TechCard>
            <p style={{ color: 'var(--imperial-gold)', fontSize: '0.9rem' }}>
              {t("home.inicio_thought")}
            </p>
            <hr style={{ border: 0, borderTop: '1px solid #333', margin: '20px 0' }} />
            <p className="mb-4">
              {t("home.inicio_welcome")}
            </p>
            <p className="mb-4">{t("home.inicio_note")}</p>
            <div className="mt-4">
              <HashLink smooth to={"/#pedidos"} className="btn-imperial">
                {t("home.inicio_button")}
              </HashLink>
            </div>
          </TechCard>
        </section>

        <section id={t("nav.muestras.href")} className="container py-5">
          <h2 className="section-title text-center mb-5">{t("home.muestras_title")}</h2>
          <div className="row g-4">
            {muestras.map((m, i) => (
              <div className="col-md-4" key={i}>
                <div className="foto-frame d-flex flex-column">
                  <div className="foto-placeholder flex-grow-1">
                    <span>{m.icon}</span>
                  </div>
                  <div className="foto-caption">
                    {m.title}
                  </div>
                </div>
              </div>
            ))}
          </div>
        </section>

        <section id={t("nav.pedidos.href")} className="container py-5">
          <h2 className="section-title text-center mb-5">{t("home.pedidos_title")}</h2>
          <TechCard>
            <p className="mb-4">{t("home.pedidos_text")}</p>
            <form>
              <div className="mb-3">
                <input type="text" className="tech-input" placeholder={t("home.pedidos_name")} />
              </div>
              <div className="mb-3">
                <input type="email" className="tech-input" placeholder={t("home.pedidos_email")} />
              </div>
              <div className="mb-4">
                <textarea className="tech-textarea" rows="6" placeholder={t("home.pedidos_requirements")}></textarea>
              </div>
              <button type="submit" className="btn-imperial border-0">{t("home.pedidos_button")}</button>
            </form>
          </TechCard>
        </section>

        <section id={t("nav.sobre.href")} className="container py-5">
          <h2 className="section-title text-center mb-5">{t("home.sobre_title")}</h2>
          <TechCard>
            <div className="row align-items-center">
              <div className="col-12">
                <p>
                  <strong>{t("home.sobre_status.k")}</strong> {t("home.sobre_status.v")}<br />
                  <strong>{t("home.sobre_location.k")}</strong> {t("home.sobre_location.v")}<br />
                  <strong>{t("home.sobre_specialty.k")}</strong> {t("home.sobre_specialty.v")}
                </p>
                <p className="mt-3 m-0">
                  {t("home.sobre_text")}
                </p>
              </div>
            </div>
          </TechCard>
        </section>

      </CustomContainer>
    </ContentWrapper>
  );
};

export default Home;
