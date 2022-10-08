import {Row, Col, Form, Button} from 'react-bootstrap'
import React from 'react'
import {login} from '../../services/auth'

class Login extends React.Component{
    constructor(props){
        super(props);

        this.state={
            username : "",
            password : ""
        }
    }

    onInputChange(event){
        const name = event.target.name;
        const value = event.target.value

        let change = {}
        change[name] = value;

        this.setState(change)
    }

    handleKeypress = e => {
        if (e.keyCode === 13) {
          this.btn.click();    }
      };

    render(){
        return(
            <Row className="justify-content-center">
                <Col md={6}>
                    <Form onKeyUp={this.handleKeypress}>
                        <Form.Group>
                            <Form.Label>Username</Form.Label>
                            <Form.Control type="text" name="username" onChange={(e)=>this.onInputChange(e)}></Form.Control>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Password</Form.Label>
                            <Form.Control type="password" name="password" onChange={(e)=>this.onInputChange(e)}></Form.Control>
                        </Form.Group>
                    </Form>
                    <Button ref={node => (this.btn = node)} onClick={()=>login(this.state.username, this.state.password)}>Log in</Button>
                </Col>
            </Row>
        )
    }
}

export default Login