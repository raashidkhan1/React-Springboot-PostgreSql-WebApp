import { fireEvent, getByText, render, screen, waitFor } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import App from './App';
import Infections from './components/Infections';
import NoVaccination from './components/NoVaccination';
import Query from './components/Query';
import Vaccination from './components/Vaccinations';

// Test cases for rendering all components

describe('Components Render', () => {
  test('App renders title react link', () => {
    render(<BrowserRouter><App /></BrowserRouter>);
    const linkElement = screen.getByText(/Lunatech Covid Assessment/i);
    expect(linkElement).toBeInTheDocument();
  });
  test('Query component renders',  () => {
    render(<BrowserRouter><Query/></BrowserRouter>);
    const linkElement = screen.getByText(/Country Name/i);
    expect(linkElement).toBeInTheDocument();
  });
  test('Vaccination component renders',  () => {
    render(<BrowserRouter><Vaccination/></BrowserRouter>);
    const linkElement = screen.getByText(/Top 10 Countries with Highest Vaccinations/i);
    expect(linkElement).toBeInTheDocument();
  });
  test('Infections component renders',  () => {
    render(<BrowserRouter><Infections/></BrowserRouter>);
    const linkElement = screen.getByText(/Top 10/i);
    expect(linkElement).toBeInTheDocument();
  });
  test('NoVaccination component renders',  () => {
    render(<BrowserRouter><NoVaccination/></BrowserRouter>);
    const linkElement = screen.getByText(/Countries/i);
    expect(linkElement).toBeInTheDocument();
  })

})
