import TechCard from "@/components/TechCard";

const VoxSection = () => (
  <section id="vox-transmision" className="container py-5">
    <h2 className="section-title text-center mb-5">+++ Súplica al Manufactorum +++</h2>
    <TechCard>
      <p className="mb-4">Rellena los datos para solicitar la atención del Artífice. Sé preciso, el tiempo es un recurso limitado del Emperador.</p>
      <form>
        <div className="mb-3">
          <input type="text" className="tech-input" placeholder="Designación del Comandante (Nombre)" />
        </div>
        <div className="mb-3">
          <input type="email" className="tech-input" placeholder="Frecuencia Vox (Email)" />
        </div>
        <div className="mb-4">
          <textarea className="tech-textarea" rows="6" placeholder="Detalla los requerimientos de la misión: Esquema de color, Facción, Nivel de degradado..."></textarea>
        </div>
        <button type="submit" className="btn-imperial border-0">Transmitir a la Noosphere</button>
      </form>
    </TechCard>
  </section>
);

export default VoxSection;