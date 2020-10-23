import React, {Fragment} from "react";
import components from "../../components/index";

export default function UsersPage(){
    const {TableComponent} = components;
    return <Fragment>
        <TableComponent title="Users table" />
    </Fragment>;
}