import React from 'react';
import {render} from 'react-dom';


class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            purchase: {},
            data: []
        };

        this.getData = this.getData.bind(this);
        this.edit = this.edit.bind(this);
        this.getPurchaseInfo = this.getPurchaseInfo.bind(this);
        this.delete = this.delete.bind(this);
        this.handleAction = this.handleAction.bind(this);
    }

    handleAction(event){
        const self = this;
        event.preventDefault();
        var $target = $(event.target);

        $.ajax({
            url: "/api/actions/" + $target.data("action"),
            dataType: "json",
            contentType: "application/json",
            method: "get",
            timeout: 3000,
            success: function (data) {
                self.setState({
                    data : data
                });
            },
            error: function () {
                console.log(arguments);
            },
            complete: function () {

            }

        });
        console.log($target.attr("data-action"));
    }


    getPurchaseInfo(event) {
        event.preventDefault();
        const self = this;
        const $target = $(event.target);
        const id = $target.attr("data-id");
        $.ajax({
            url: "/api/" + id,
            dataType: "json",
            contentType: "application/json",
            method: "get",
            timeout: 3000,
            success: function (data) {
                self.setState({
                    purchase: data
                });
            },
            error: function () {
                console.log(arguments);
            },
            complete: function () {

            }

        });

    }

    edit(event){
        event.preventDefault();
        const self = this;
        const $target = $(event.target);
        const id = $target.attr("data-id");

        var data = {};

        $target.serializeArray().map((element, i)=>{
            console.log(element);
            data[element.name] = element.value
        });

        $.ajax({
            url: "/api/" + id,
            dataType: "json",
            contentType: "application/json",
            type: "PUT",
            data : JSON.stringify(data),
            timeout: 3000,
            success: function (data) {
                self.getData();
                $("#exampleModal").modal("hide");
                /*self.setState({
                    purchase: data
                });*/
            },
            error: function () {
                console.log(arguments);
            },
            complete: function () {

            }

        });
    }


    delete(event){
        event.preventDefault();
        const self = this;
        const $target = $(event.target);
        const id = $target.attr("data-id");

        $.ajax({
            url: "/api/" + id,
            dataType: "json",
            contentType: "application/json",
            type: "DELETE",
            timeout: 3000,
            success: function (data) {
                self.getData();
                $("#exampleModal").modal("hide");
            },
            error: function () {
                console.log(arguments);
            },
            complete: function () {}

        });
    }

    getData(){

    }

    getData() {
        const self = this;

        const date = new Date();

        $.ajax({
            url: "/api",
            dataType: "json",
            contentType: "application/json",
            method: "get",
            timeout: 3000,
            success: function (data) {
                self.setState({
                    data: data
                });
            },
            error: function () {
                console.log(arguments);
            },
            complete: function () {

            }

        });
    }

    componentDidMount() {
        const self = this;
        this.getData();
    }


    render() {

        return (
            <div>
                <div>
                    <a href="" onClick={this.handleAction} data-action={"last_week"}>список покупок за последнюю неделю</a>
                </div>
                <div>
                    <a href=""  onClick={this.handleAction} data-action={"most_buy"}>самый покупаемый товар за последний месяц</a>
                </div>

               {/* <div>
                    <a href="" onClick={this.handleAction} data-action={"most_buy_fio_last_half_year"}>имя и фамилия человека, совершившего больше всего покупок за полгода</a>
                </div>*/}
               {/* <div>
                    <a href="" onClick={this.handleAction} data-action={"18years_most_buy"}>Что чаще всего покупают люди в возрасте 18 лет</a>
                </div>*/}


            <table className="table table-bordered">
                    <thead>
                    <tr>
                        <th>Имя</th>
                        <th>Фамилия</th>
                        <th>Возраст</th>
                        <th>Содержимое покупки</th>
                        <th>Количество товара</th>
                        <th>Сумма покупки</th>
                        <th>Дата покупки</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>

                    {this.state.data.map((element, index) =>
                        <tr key={index}>
                            <td>
                                {element.name}
                            </td>
                            <td>
                                {element.lastname}
                            </td>
                            <td>
                                {element.age}
                            </td>
                            <td>
                                {element.purchase.name}
                            </td>
                            <td>
                                {element.count}
                            </td>
                            <td>
                                {element.amount}
                            </td>
                            <td>
                                {element.creationDate}

                            </td>
                            <td>
                                <small>
                                    <a href="/edit/"
                                       data-toggle="modal"
                                       data-target="#exampleModal"
                                       data-id={element.id}
                                       onClick={this.getPurchaseInfo}>Edit</a>
                                    <a href="/delete/" className="delete ml-1" onClick={this.delete} data-id={element.id}>Delete</a>
                                </small>
                            </td>
                        </tr>
                    )}
                    </tbody>

                </table>

                <div className="modal fade" id="exampleModal" tabIndex="-1" role="dialog"
                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div className="modal-dialog" role="document">
                            <div className="modal-content">
                                <div className="modal-header">
                                    <h5 className="modal-title" id="exampleModalLabel">Modal title</h5>
                                    <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div className="modal-body" id="edit-modal">
                                    <form action="" onSubmit={this.edit} data-id={this.state.purchase.id} method="post">

                                        <input type="hidden" name="id" defaultValue={this.state.purchase.id}/>
                                        <label htmlFor="name">
                                            Имя
                                        </label>
                                        <input type="text" className="form-control"
                                               defaultValue={this.state.purchase.name} name="name"/>
                                        <label htmlFor="lastname">
                                            Фамилия
                                        </label>
                                        <input type="text" className="form-control"
                                               defaultValue={this.state.purchase.lastname} name="lastname"/>
                                        <label htmlFor="age">
                                            Возраст
                                        </label>
                                        <input type="text" className="form-control"
                                               defaultValue={this.state.purchase.age} name="age"/>
                                        <label htmlFor="count">
                                            Количество товара
                                        </label>
                                        <input type="text" className="form-control"
                                               defaultValue={this.state.purchase.count} name="count"/>
                                        <label htmlFor="age">
                                            Сумма покупки
                                        </label>
                                        <input type="text" className="form-control"
                                               defaultValue={this.state.purchase.amount}
                                               name="amount"/>

                                        <label htmlFor="creation_date">
                                            Дата покупки
                                        </label>
                                        <input readOnly type="text" className="form-control"
                                               defaultValue={this.state.purchase.creationDate} name="creation_date"/>

                                        <label htmlFor="creation_date">
                                            Содержимое покупки
                                        </label>
                                        <input type="hidden" name="purchase_id"
                                               defaultValue={this.state.purchase.name}/>
                                        <input readOnly type="text" className="form-control"
                                               defaultValue={this.state.purchase.name} name="creation_date"/>

                                        <div className="modal-footer">
                                            <button type="button" className="btn btn-secondary" data-dismiss="modal">Close
                                            </button>
                                            <button type="submit"  className="btn btn-primary">Save changes</button>
                                        </div>

                                    </form>
                                </div>

                            </div>
                    </div>
            </div>
            </div>
   )
                }
                }




                $(function () {

                render(
                    <App/>
                    , document.getElementById('table'));
            })


