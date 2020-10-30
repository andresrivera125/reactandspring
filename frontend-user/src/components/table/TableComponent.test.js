import React, {Fragment} from "react";
import {render} from "@testing-library/react";
import TableComponent, {TESTID_TITLE} from "./TableComponent";

describe("Unit test to TableComponent: ", () =>
{
    test('Should contain the title sent', () => {
        const mockTitle = "Mock title";
        const {getByTestId} = render(<TableComponent title={mockTitle}/>);
        const element = getByTestId(TESTID_TITLE);
        expect(element).toBeInTheDocument();
        expect(element).toHaveTextContent(mockTitle);
    });
});