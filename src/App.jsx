import Footer from '@/components/Footer'
import Header from '@/components/Header'
import NavBar from '@/components/NavBar/NavBar'
import Home from '@/pages/Home'
import { Route, Routes } from 'react-router-dom'
import Login from './pages/Login'

const App = () => {
  return (
    <>
      <Header />
      <NavBar />
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/login' element={<Login />} />
      </Routes>
      <Footer />
    </>
  );
}

export default App;
