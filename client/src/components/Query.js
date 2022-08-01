import Button from "react-bootstrap/Button"
import React, { Component } from "react";
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import 'react-bootstrap-table-next/dist/react-bootstrap-table2.min.css';
import BootstrapTable from 'react-bootstrap-table-next';
import paginationFactory from "react-bootstrap-table2-paginator";
import CovidDataService from '../utils/services';

const columns = [{
    dataField: 'serial',
    text: 'S.No.'
  }, {
    dataField: 'infections',
    text: 'Infections'
  },{
    dataField: 'deaths',
    text: 'Deaths'
  }, {
    dataField: 'recordedDate',
    text: 'Recorded Date'
}];

// This component serves the data for infections and death upto a specified page
class Query extends Component{

state = {
    data: [],
    countryName: '',
    date: ''
}

constructor(){
    super();
    this.onSubmitHandler = this.onSubmitHandler.bind(this);
}

onSubmitHandler(e){
    e.preventDefault();
    const countryName = this.state.countryName
    const date = this.state.date
    CovidDataService.queryData(countryName, date)
        .then((response)=>{
            let formatResponse = []
            if(response && response.data){
                let count = 0;
                response.data.forEach((value)=>{
                    formatResponse.push({
                        serial: ++count,
                        infections: value[0],
                        deaths: value[1],
                        recordedDate: value[2]
                    })
                })
                this.setState({...this.state, data: formatResponse})
            }
            if (response.data.length === 0){
                this.setState({...this.state, data: null})
            }
        })
        .catch(e=>{
            console.log(e);
        })

}

 render(){
    return(
        <div style={{width: 500, marginLeft: 100}}>
        <Form>
        <Form.Label>Query Infections and Deaths until a specific date</Form.Label>
        <Row>
        <Col>
        <Form.Label>Country Name</Form.Label>
        <Form.Control type="text" id="countryName" 
            placeholder="Enter a country name"
            value={this.state.countryName}
            onChange={e=> this.setState({...this.state, countryName: e.target.value})}
            data-testid="country"
            ></Form.Control>
        </Col>
        <Col>
        <Form.Label>Specify Date</Form.Label>
        <Form.Control type="date" id="specifyDate" 
            locale={{format: 'YYYY-MM-DD'}} 
            placeholder="Specify date"
            value={this.state.date}
            onChange={e => this.setState({...this.state, date: e.target.value})}
            data-testid="date"
            ></Form.Control>
        </Col>
        </Row>
        <br/>
        <Row>
        <Col>
        <Button type="submit" onClick={this.onSubmitHandler}>Submit</Button>
        </Col>
        </Row>
        </Form>
        <br/>
        {this.state.data && this.state.data.length>0 ? 
        <div>
            <BootstrapTable keyField='serial' 
            data={this.state.data} 
            columns={columns}
            pagination={paginationFactory({ sizePerPage: 10 })}
            />
        </div> : ""}
        
        {this.state.data === null ? <h2>No Data Found</h2> : ""}
        </div>
    )
 }   
}

export default Query;