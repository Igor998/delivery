import React from "react";
import { withNavigation } from "../../routeconf";
import TestAxios from "../../apis/TestAxios";
import { Button, Form, FormControl, FormGroup, FormSelect, FormLabel } from "react-bootstrap";

class NarudzbaAdd extends React.Component {

    constructor(props){
        super(props);

        let narudzba = {
            brojNarudzbe: 0,
            datumKreiranja: "",
            mestoIsporuke: "0",
            cena: 0,
            opis: "",
            dostavljacId: -1
        }

        this.state = {
            narudzba: narudzba,
            dostavljaci : []         
        }
    }

    componentDidMount(){
        this.getDostavljace()
    }


    async getDostavljace() {
        try {
            let res = await TestAxios.get("/dostavljaci");
            if (res && res.status === 200) {
                this.setState({
                    dostavljaci: res.data
                })
            }
        } catch (error) {
            alert("Nije uspelo dobavljanje dostavljaca.");
        }
    }

    valueInputChange(event) {
        let name = event.target.name;
        let value = event.target.value;

        let narudzba = this.state.narudzba;

        narudzba[name] = value;

        this.setState({ narudzba : narudzba });
    }

    async create(){
        try{
            let res = await TestAxios.post("/narudzbe", this.state.narudzba);
            if (res && res.status === 201){
                this.navigateNarudzbe();
            }
        } catch (err) {
            alert("Dodavanje Narudzbe nije uspelo!");
        }
    }

    navigateNarudzbe(){
        this.props.navigate("/narudzbe");
    }


    render(){
            return(
                <Form>
                    <FormGroup>
                        <FormLabel>
                            Broj narudzbe
                        </FormLabel>
                        <FormControl
                            placeholder="Broj narudzbe"    
                            name = "brojNarudzbe"
                            onChange = {(e) => this.valueInputChange(e)}
                            type="number"
                            min = "0"
                            step = "1"
                        ></FormControl>
                    </FormGroup>
                    <FormGroup>
                        <FormLabel>
                            Datum kreiranja
                        </FormLabel>
                        <FormControl   
                            name = "datumKreiranja"
                            type="date"
                            onChange = {(e) => this.valueInputChange(e)}
                        ></FormControl>
                    </FormGroup>
                    <FormGroup>
                        <FormLabel>
                            Mesto isporuke
                        </FormLabel>
                        <FormControl
                            placeholder="Mesto isporuke"    
                            name = "mestoIsporuke"
                            as = "input"
                            onChange = {(e) => this.valueInputChange(e)}
                        ></FormControl>
                    </FormGroup>
                    <FormGroup>
                        <FormLabel>
                            Cena narudzbe
                        </FormLabel>
                        <FormControl
                            placeholder="Cena narudzbe"    
                            name = "cena"
                            as = "input"
                            onChange = {(e) => this.valueInputChange(e)}
                            type = "number"
                            min = "0"
                            step = "0.1"
                        ></FormControl>
                    </FormGroup>
                    <FormGroup>
                        <FormLabel>
                            Opis
                        </FormLabel>
                        <FormControl
                            placeholder="Opis"    
                            name = "opis"
                            as = "input"
                            onChange = {(e) => this.valueInputChange(e)}
                        ></FormControl>
                    </FormGroup>
                    <FormGroup>
                        <FormLabel>
                            Dostavljac
                        </FormLabel>
                        <FormSelect
                            onChange = {(e) => this.valueInputChange(e)}
                            name = "dostavljacId"
                        >
                            <option value={-1}></option>
                            {this.state.dostavljaci.map((sel) => {
                                return (
                                    <option value={sel.id} key={sel.id}>
                                        {sel.imePrezime}
                                    </option>
                                )
                            })}
                        </FormSelect>
                    </FormGroup>

                    <Button style={{marginTop: "30px"}} onClick={() => this.create()}>Dodajte</Button>
                </Form>
            )
    }
}

export default withNavigation(NarudzbaAdd);