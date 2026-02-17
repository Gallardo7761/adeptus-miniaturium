import Footer from '@/components/Footer'
import Header from '@/components/Header'
import NavBar from '@/components/NavBar/NavBar'
import Home from '@/pages/Home'
import { Route, Routes, useLocation } from 'react-router-dom'
import Login from './pages/Login'
import "./i18n";

const App = () => {
  const withoutFooter = ["/login"]
  const location = useLocation();

  return (
    <>
      <Header profilePic={"/images/pfp.jpg"}/>
      <NavBar />
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/login' element={<Login />} />
      </Routes>
      {!withoutFooter.includes(location.pathname) && <Footer />}
    </>
  );
}

export default App;
