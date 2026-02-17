import '@/css/TechCard.css'

const TechCard = ({ children, className = '' }) => (
  <div className={`tech-card ${className}`}>
    {children}
  </div>
);

export default TechCard;