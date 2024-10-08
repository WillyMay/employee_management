
import './App.css'
import Header from './components/Header'
import ListEmployee from './components/ListEmployee'
import Footer from './components/Footer'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Employee from './components/Employee'


function App() {
  return (
    <>
      <BrowserRouter>
        <Header />
        <div className= "container">
          <Routes>
              <Route path = "/" element = { <ListEmployee /> }></Route>
              <Route path = "/employees" element = { <ListEmployee /> }></Route>
              <Route path = "/add-employee" element = { <Employee />} ></Route>
              <Route path = "/edit-employee/:id" element = { <Employee />}></Route>
            </Routes>
        </div>
        <Footer />
        </BrowserRouter>
    </>
  )
}

export default App
