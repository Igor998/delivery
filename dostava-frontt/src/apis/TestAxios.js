import axios from 'axios';
import jwt_decode from "jwt-decode";
import { logout } from '../services/auth';

var TestAxios = axios.create({
  baseURL: 'http://localhost:8080/api',
});

TestAxios.interceptors.request.use(
  function presretac(config){
    const jwt = window.localStorage['jwt']
    if(jwt){
      const decoded = jwt_decode(jwt)
      if(decoded.exp_date<Date.now()){
        alert("Istekao jwt")
        logout()
        return false
      }
      config.headers['Authorization']="Bearer " + jwt
    }
    return config;
  }
);

TestAxios.interceptors.response.use(
  function success(response){
      return response;
  },
  function failure(error){
    let jwt = window.localStorage['jwt'];
    if(jwt){
      if(error.response && error.response.status == 403){
        logout();
      }
    }
    
    throw error;
  }
);

export default TestAxios;