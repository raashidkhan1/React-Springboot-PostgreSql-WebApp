import React, { Component } from "react";
import BootstrapTable from "react-bootstrap-table-next";
import CovidDateService from "../utils/services";
import 'react-bootstrap-table-next/dist/react-bootstrap-table2.min.css';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';

const columns1 = [{
   dataField: 'serial',
   text: 'S.No.'
 }, {
   dataField: 'vaccinations',
   text: 'Highest Vaccinations'
 }, {
   dataField: 'name',
   text: 'Country Name'
}];

const columns2 = [{
   dataField: 'serial',
   text: 'S.No.'
 }, {
   dataField: 'vaccinations',
   text: 'Lowest Vaccinations'
 }, {
   dataField: 'name',
   text: 'Country Name'
}];

// // This component serves the Top 10 Countries with highest/lowest vaccinations page
class Vaccination extends Component{

state = {
   data1: [],
   data2: []
}
 
 componentDidMount(){
  CovidDateService.getVaccinations()
   .then(response => {
      if(response && response.data){
         let formatResponse1 = [];
         let formatResponse2 = [];
         Object.keys(response.data).map((identifier)=>{
            let count = 0;
            if(identifier === "highest"){
               response.data[identifier].forEach((value)=>{
                  formatResponse1.push({
                     serial: ++count,
                     vaccinations: value.vaccinationCount,
                     name: value.countryName
                 })
               })
            }
            if(identifier === "lowest"){
               response.data[identifier].forEach((value)=>{
                  formatResponse2.push({
                     serial: ++count,
                     vaccinations: value.vaccinationCount,
                     name: value.countryName
                 })
               })
            }
            return "";
         })
         this.setState({data1: formatResponse1, data2: formatResponse2});
      }
  })
  .catch(e=>{
   console.log(e);
  })

 }

 render(){
    return(
      <div style={{width: 700, marginLeft: 100}}>
         <Row>
            <Col>
               <h2>Top 10 Countries with Highest Vaccinations</h2>
               <BootstrapTable keyField='serial' data={this.state.data1} columns={columns1}/>
            </Col>
            <Col>
               <h2>Top 10 Countries with Lowest Vaccinations</h2>
               <BootstrapTable keyField='serial' data={this.state.data2} columns={columns2}/>
            </Col>

         </Row>
         
      </div>
    )
 }   
}

export default Vaccination;