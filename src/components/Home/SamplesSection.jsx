const SamplesSection = () => {
  const muestras = [
    { icon: '☠', title: 'Muestra A-1: Astartes Pattern' },
    { icon: '⚙', title: 'Muestra B-2: Engine War' },
    { icon: '⚔', title: 'Muestra C-3: Xenos Filth' },
  ];

  return (
    <section id="pict-capturas" className="container py-5">
      <h2 className="section-title text-center mb-5">+++ Muestras +++</h2>
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
  );
};

export default SamplesSection;