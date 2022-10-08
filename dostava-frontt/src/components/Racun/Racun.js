import React from "react";
import { withNavigation, withParams } from "../../routeconf";
import TestAxios from "../../apis/TestAxios";
import { Button, Table } from "react-bootstrap";

class Racun extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            racun: "",
            dostavljaci: []
        }
    }

    componentDidMount() {
        this.getData()
    }

    async getData() {
        await this.getRacun();
    }

    async getRacun() {
        try {
            let res = await TestAxios.get("/racuni/" + this.props.params.id);
            if (res && res.status === 200) {
      
              this.setState({
                racun: res.data
              })
            }
          } catch (err) {
            console.log(err)
            alert("Nije uspelo dobavljanje racuna.");
          }
    }

    goToPrikaz(){
        this.props.navigate("/narudzbe");
    }

    render(){
        return <>
            <Table bordered striped hover style={{ marginTop: 5 }}>
                <thead>
                    <tr>
                        <th>Broj racuna</th>
                        <th>Datum</th>
                        <th>Ukupna cena</th>
                        <th>ID narudzbe</th>
                    </tr>
                </thead>
                <tbody>
                            <tr>
                                <td>{this.state.racun.brojRacuna}</td>
                                <td>{this.state.racun.datumKreiranja}</td>
                                <td>{this.state.racun.ukupnaCena}</td>
                                <td>{this.state.racun.narudzbaId}</td>
                            </tr>
                </tbody>
            </Table>

            <br />

            <Button onClick={() => this.goToPrikaz()}>Nazad</Button>
            </>
    }
}

    export default withNavigation(withParams(Racun));