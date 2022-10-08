import React from "react";
import ReactDOM from "react-dom";
import { HashRouter as Router, Routes, Route, Link, Navigate } from "react-router-dom";
import { Navbar, Container, NavbarBrand, Nav, NavLink, Button } from "react-bootstrap";
import { logout } from "./services/auth";
import Login from "./components/authorization/Login";
import Home from "./components/Home";
import NotFound from "./components/NotFound";
import Narudzbe from "./components/Narudzbe/Narudzbe";
import NarudzbaAdd from "./components/Narudzbe/NarudzbaAdd";
import Racun from "./components/Racun/Racun";
import App from "./App";

class Index extends React.Component {

    render(){
        const jwt = window.localStorage['jwt'];

        if(jwt) {
            return (<>
                <Router>
                    <Navbar expand bg="dark" variant="dark">
                        <NavbarBrand as={Link} to="/">
                            Narudzbivaonica
                        </NavbarBrand> 
                        <Nav className="mr-auto">
                            <NavLink as={Link} to="/narudzbe">
                                Narudzbe
                            </NavLink>
                            <Button onClick={()=>logout()}>Logout</Button>
                        </Nav>
                    </Navbar>
                    <Container style={{paddingTop:"10px"}}>
                        <Routes>
                            <Route path="/" element={<Home/>}/>
                            <Route path="/login" element={<Navigate replace to="/"/>}/>
                            <Route path="/narudzbe" element={<Narudzbe/>}/>
                            <Route path="/narudzbe/add" element={<NarudzbaAdd/>}/>
                            <Route path="/racuni/:id" element={<Racun/>}/>
                            <Route path="*" element={<NotFound/>}/>
                        </Routes>
                    </Container>
                </Router>
            </>)
        } else {
            return(
                <>
                    <Router>
                        <Navbar expand bg="dark" variant="dark">
                            <NavbarBrand as={Link} to="/">
                                Narudzbivaonica
                            </NavbarBrand>
                            <Nav className="mr-auto">
                                <NavLink as={Link} to="/login">
                                    Login
                                </NavLink>
                            </Nav>
                        </Navbar>
                        <Container style={{paddingTop:"10px"}}>
                            <Routes>
                                <Route path="/" element={<Home/>}/>
                                <Route path="/login" element={<Login/>}/>
                                <Route path="*" element={<Navigate replace to="/login"/>}/>
                            </Routes>
                        </Container>
                    </Router>
                </>)
        }
    }
}

ReactDOM.render(
    <><App /><Index /></>,
    document.querySelector('#root')
);