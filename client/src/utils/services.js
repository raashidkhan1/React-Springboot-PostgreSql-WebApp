import http from "./axios-http"

class CovidDataService {

    queryData(name, date){
        return http.get(`/queryInfecDeaths?name=${name}&date=${date}`)
    }

    getVaccinations(){
        return http.get('/getHighestLowestVaccinations')
    }

    getInfections(){
        return http.get('/getHighestInfections')
    }

    getUnVaccinatedCountries(){
        return http.get('/getUnVaccinatedCountries')
    }
}

export default new CovidDataService();