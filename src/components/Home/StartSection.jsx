import TechCard from "@/components/TechCard";

const StartSection = () => (
  <section id="inicio" className="container py-5">
    <h2 className="section-title text-center mb-5">+++ INICIALIZANDO +++</h2>
    <TechCard>
      <p style={{ color: 'var(--imperial-gold)', fontSize: '0.9rem' }}>
        // PENSAMIENTO DEL DÍA: LA ESPERANZA ES EL PRIMER PASO HACIA LA DECEPCIÓN.
      </p>
      <hr style={{ border: 0, borderTop: '1px solid #333', margin: '20px 0' }} />
      <p className="mb-4">
        Bienvenido al manufactorum personal de <strong>Markcus</strong>. Aquí, las miniaturas grises son purgadas de su falta de color y bendecidas con pigmentos sagrados, lavados de Nuln Oil y pincel seco ritual.
      </p>
      <p className="mb-4">No pintamos juguetes. Forjamos veteranos de la Larga Guerra.</p>
      <div className="mt-4">
        <a href="#vox-transmision" className="btn-imperial">Iniciar Protocolo de Encargo</a>
      </div>
    </TechCard>
  </section>
);

export default StartSection;