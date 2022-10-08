import React from "react";
import { Button, ButtonGroup, Col, Form, FormControl, FormGroup, FormLabel, FormSelect, Row, Table } from "react-bootstrap";
import TestAxios from "../../apis/TestAxios";
import { withNavigation, withParams } from "../../routeconf";

class Narudzbe extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            narudzbe: [],
            dostavljaci: [],
            search: { mestoIsporuke: "", dostavljacId: -1 },
            pageNo: 0,
            totalPages: 1
        }
    }

    componentDidMount() {
        this.getData()
    }

    async getData() {
        await this.getNarudzbe(0);
        await this.getDostavljace();
    }

    async getNarudzbe(page) {

        let config = {
            params: {
                pageNo: page
            }
        }

        if (this.state.search.mestoIsporuke != "") {
            config.params.mestoIsporuke = this.state.search.mestoIsporuke;
        }

        if (this.state.search.dostavljacId != -1) {
            config.params.dostavljacId = this.state.search.dostavljacId;
        }

        try {
            let res = await TestAxios.get("/narudzbe", config);
            if (res && res.status === 200) {

                this.setState({
                    pageNo: page,
                    totalPages: res.headers["total-pages"],
                    narudzbe: res.data
                })
            }
        } catch (err) {
            console.log(err)
            alert("Nije uspelo dobavljanje narudzbi.");
        }
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

    searchValueInputChange(event) {
        let name = event.target.name;
        let value = event.target.value;

        let search = this.state.search;
        search[name] = value;

        this.setState({ search: search });

        this.getNarudzbe(0);
    }

    async delete(narudzbaId) {
        try {
            let res = await TestAxios.delete("/narudzbe/" + narudzbaId);
            if (res && res.status === 204){
            
                let nextPage;
                if (this.state.pageNo == this.state.totalPages - 1 && this.state.narudzbe.length == 1 && this.state.pageNo != 0) {
                    nextPage = this.state.pageNo - 1
                } else {
                    nextPage = this.state.pageNo
                }

                await this.getNarudzbe(nextPage);
            }
        } catch (error) {
            alert("Nije uspelo brisanje narudzbe.");
        }
    }

    async kreirajRacun(narudzbaId, cena, brojNarudzbe){
        let datumKreiranja = new Date();

        let racun = {
            brojRacuna: brojNarudzbe,
            datumKreiranja: datumKreiranja,
            ukupnaCena: cena,
            narudzbaId: narudzbaId
        }

        try{
            let res = await TestAxios.post("/racuni", racun);
            if (res && res.status === 201){
                this.getNarudzbe(this.state.pageNo);
            }
        } catch(err){
            alert("Nije uspelo kreiranje racuna!");
        }   
    }

    goToAdd() {
        this.props.navigate("/narudzbe/add");
    }

    goToRacun(id){
        this.props.navigate("/racuni/" + id);
    }

    render() {
        return <>

            <h1>Narudzbe</h1>
            <br />
            <h3>Pretraga</h3>
            <Form>
                <FormGroup>
                    <FormLabel>
                        Dostavljac
                    </FormLabel>
                    <FormSelect
                        onChange={(e) => this.searchValueInputChange(e)}
                        name="dostavljacId"
                        value={this.state.search.dostavljacId}
                    >
                        <option value={-1}></option>
                        {this.state.dostavljaci.map((ent) => {
                            return (
                                <option value={ent.id} key={ent.id}>
                                    {ent.imePrezime}
                                </option>
                            )
                        })}
                    </FormSelect>
                </FormGroup>
                <FormGroup>
                    <FormLabel>
                        Mesto Isporuke
                    </FormLabel>
                    <FormControl
                        placeholder="Mesto Isporuke"
                        value={this.state.search.mestoIsporuke}
                        name="mestoIsporuke"
                        onChange={(e) => this.searchValueInputChange(e)}
                    ></FormControl>
                </FormGroup>
            </Form>

            <br />
            <br />

            <Button onClick={() => this.goToAdd()}>Dodajte proizvod</Button>

            <br />
            <br />

            <ButtonGroup style={{ marginTop: 5, marginBottom: 15, float: "right" }}>
                <Button
                    style={{ width: 90, backgroundColor: "#3bafb8", border: "none" }}
                    disabled={this.state.pageNo == 0} onClick={() => this.getNarudzbe(this.state.pageNo - 1)}>
                    Prethodna
                </Button>
                <Button
                    style={{ width: 90, backgroundColor: "#3bafb8", border: "none" }}
                    disabled={this.state.pageNo >= this.state.totalPages - 1} onClick={() => this.getNarudzbe(this.state.pageNo + 1)}>
                    Sledeca
                </Button>
            </ButtonGroup>

            <Table bordered striped hover style={{ marginTop: 5 }}>
                <thead>
                    <tr  style={{ backgroundColor: "black", color: "white" , borderColor: "black"}}>
                        <th>Broj narudzbe</th>
                        <th>Datum</th>
                        <th>Mesto isporuke</th>
                        <th>Cena</th>
                        <th>Opis</th>
                        <th>Dostavljac</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {this.state.narudzbe.map((narudzba, index) => {
                        return (
                            <tr key={narudzba.id}>
                                <td>{narudzba.brojNarudzbe}</td>
                                <td>{narudzba.datumKreiranja}</td>
                                <td>{narudzba.mestoIsporuke}</td>
                                <td>{narudzba.cena}</td>
                                <td>{narudzba.opis}</td>
                                <td>{narudzba.dostavljacImePrezime}</td>

                                {narudzba.racunId == -1 ?
                                    <td>
                                        <Button
                                            name="kreirajRacun"
                                            style={{ marginRight: "10px" }}
                                            variant="success"
                                            onClick={() => this.kreirajRacun(narudzba.id, narudzba.cena, narudzba.brojNarudzbe)}>
                                            Kreiraj racun
                                        </Button>
                                    </td>
                                    :
                                    <td>
                                        <Button
                                            name="vidiRacun"
                                            onClick={() => this.goToRacun(narudzba.racunId)}>
                                            Vidi racun
                                        </Button>
                                    </td>
                                }
                                <td>
                                <Button onClick={() => this.delete(narudzba.id)} variant="danger">
                                            Obrisi
                                        </Button>
                                </td>
                            </tr>
                        )
                    })}
                </tbody>
            </Table>
        </>
    }
}

export default withNavigation(withParams(Narudzbe));