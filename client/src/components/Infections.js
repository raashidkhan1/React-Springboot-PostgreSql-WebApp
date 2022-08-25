import React, { Component } from "react";
import BootstrapTable from "react-bootstrap-table-next";
import 'react-bootstrap-table-next/dist/react-bootstrap-table2.min.css';
import CovidDateService from "../utils/services";

const columns = [{
   dataField: 'serial',
   text: 'S.No.'
 }, {
   dataField: 'infections',
   text: 'Infections'
 }, {
   dataField: 'name',
   text: 'Country Name'
}];

// This component serves the Top 10 Countries with highest infections page
class Infections extends Component{

   state={
      data: []
   }
   
   componentDidMount(){
      CovidDateService.getInfections()
      .then((response)=>{
         let formatResponse = []
         if(response && response.data){
             let count = 0;
             response.data.forEach((value)=>{
                 formatResponse.push({
                     serial: ++count,
                     infections: value.infectionsCount,
                     name: value.countryName,
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
         <h2 style={{marginLeft: 100}}>Top 10 Countries with Highest Infections per 100k inhabitants</h2>
         <div style={{ width: 700, marginLeft: 100}}>
            <BootstrapTable keyField='serial' data={this.state.data} columns={columns} />
         </div>
       </>
      )
 }   
}

export default Infections;