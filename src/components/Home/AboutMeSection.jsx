import TechCard from "@/components/TechCard";

const AboutMeSection = () => (
  <section id="datos-biologis" className="container py-5">
    <h2 className="section-title text-center mb-5">+++ Archivo: Markcus +++</h2>
    <TechCard>
      <div className="row align-items-center">
        <div className="col-12">
          <p>
            <strong>[ESTADO]</strong>: Operativo<br />
            <strong>[UBICACIÓN]</strong>: Andalucía<br />
            <strong>[ESPECIALIDAD]</strong>: Grimdark Realista, Weathering pesado, OSL.
          </p>
          <p className="mt-3 m-0">
            Markcus no pinta para que queden bonitos en la estantería. Pinta para que parezca que tus muñecos han sobrevivido a un bombardeo orbital en Istvaan V. Aquí hay barro, sangre y oscuridad.
          </p>
        </div>
      </div>
    </TechCard>
  </section>
);

export default AboutMeSection;