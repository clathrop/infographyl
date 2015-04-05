/*
 * Javascript to manage the JTable
 */

$(document).ready(function() {
    //setup the jtable that will display the results
    $('#InfographicTableContainer').jtable({
        title: 'Table of Expenses',
        selecting: true, //Enable selecting
        paging: true, //Enable paging
        pageSize: 10, //Set page size (default: 10)
        sorting: true, //Enable sorting
        actions: {
            listAction: 'infographicTable/listInfographics'
            //createAction: 'infographicTable/addExpense',
           // updateAction: 'infographicTable/updateExpense',
            //deleteAction: 'infographicTable/deleteExpense'
        },
        fields: {
            id: {
                title: 'ID',
                width: '10%',
                key: true,
                create: false,
                edit: false
            },
            name: {
                title: 'Name',
                width: '30%'
            },
            description: {
                title: 'Description',
                width: '15%'
            },
            url: {
                title: 'Url',
                width: '15%'
            },
            category: {
                title: 'Category',
                width : '20%',
                edit  : false
            },
            tags: {
                title: 'Tags',
                width: '25%'
            }
        },
    });
    $('#InfographicTableContainer').jtable('load');
});