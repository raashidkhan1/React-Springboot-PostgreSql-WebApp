import React from "react";
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import {Routes, Route} from 'react-router-dom'
import Infections from "./Infections";
import NoVaccination from "./NoVaccination";
import Query from "./Query";
import Vaccination from "./Vaccinations";

// This component is used as a navigation bar on top as seen in the UI, provides routes to other components
function Navigation(){
    return(
        <div>
        <Navbar bg="light" expand="lg">
        <Container>
          <Navbar.Brand href="/">Lunatech Covid Assessment</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link href="/">Home</Nav.Link>
              <Nav.Link href="/query">Query Covid Data</Nav.Link>
              <NavDropdown title="Reports" id="basic-nav-dropdown">
                <NavDropdown.Item href="/vaccinations">Top 10 Countries with Highest/Lowest Vaccinations</NavDropdown.Item>
                <NavDropdown.Item href="/infections">
                  Top 10 Countries with Highest infections per 100k inhabitants
                </NavDropdown.Item>
                <NavDropdown.Item href="/novaccination">Countries with no vaccinations</NavDropdown.Item>
              </NavDropdown>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
        <div>
        <Routes>
            <Route exact path="/query" element={<Query/>} />
            <Route exact path="/vaccinations" element={<Vaccination/>} />
            <Route path="/infections" element={<Infections/>} />
            <Route path="/novaccination" element={<NoVaccination/>}/>
        </Routes>
        </div>
    </div>
    )
}

export default Navigation;