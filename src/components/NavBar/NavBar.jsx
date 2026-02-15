import '@/css/NavBar.css';
import NavItem from './NavItem';

const navItems = [
  { label: 'Inicio', href: '/#inicio' },
  { label: 'Muestras', href: '/#muestras' },
  { label: 'Pedidos', href: '/#pedidos' },
  { label: 'Sobre Markcus', href: '/#sobre-mi' },
  { label: "🇪🇸", href: '#' },
  { label: "Login", href: '/login' }
];

const NavBar = () => {
  const centerItems = navItems.slice(0, navItems.length - 2);
  const rightItems = navItems.slice(-2);

  return (
    <nav className="nav-container">
      <ul className="d-flex align-items-center list-unstyled m-0 w-100 justify-content-center position-relative">

        {centerItems.map((item, index) => (
          <NavItem key={index} item={item} index={index} total={centerItems.length} />
        ))}

        <li className="position-absolute end-0 d-flex">
          {rightItems.map((item, index) => (
            <NavItem key={index} item={item} index={index} total={rightItems.length} />
          ))}
        </li>

      </ul>
    </nav>
  );
};

export default NavBar;