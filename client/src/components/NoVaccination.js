import React, { Component } from "react";
import BootstrapTable from "react-bootstrap-table-next";
import 'react-bootstrap-table-next/dist/react-bootstrap-table2.min.css';
import CovidDateService from "../utils/services";

const columns = [{
   dataField: 'serial',
   text: 'S.No.'
 }, {
   dataField: 'vaccinations',
   text: 'Vaccinations'
 }, {
   dataField: 'name',
   text: 'Country Name'
}];

// This component serves the Countries with no vaccinations page
class NoVaccination extends Component{

 state={
   data: []
 }

 componentDidMount(){
   CovidDateService.getUnVaccinatedCountries()
   .then((response)=>{
      let formatResponse = []
      if(response && response.data){
          let count = 0;
          response.data.forEach((value)=>{
              formatResponse.push({
                  serial: ++count,
                  vaccinations: value[0],
                  name: value[1],
              })
          })
          this.setState({data: formatResponse})
      }
  })
  .catch(e=>{
      console.log(e);
  })
 }

 render(){
    return(
      <>
      <h2 style={{marginLeft: 100}}>Countries with no vaccinations</h2>
      <div style={{ width: 500, marginLeft: 100 }}>
          {this.state.data.length > 0 ?
             <BootstrapTable keyField='serial' data={this.state.data} columns={columns} />
             : <h2>No Data found</h2>}
       </div>
      </>
    )
 }   
}

export default NoVaccination;