/*
 * Javascript to manage the JTable
 */

$(document).ready(function() {
    //setup the jtable that will display the results
    $('#InfographicTableContainer').jtable({
        title: 'Infographic Table',
        selecting: false, //Enable selecting
        paging: true, //Enable paging
        pageSize: 10, //Set page size (default: 10)
        sorting: false, //Enable sorting
        actions: {
            listAction: 'infographicTable/listInfographics',
            createAction: 'infographicTable/createInfographic',
            updateAction: 'infographicTable/updateInfographic'
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
                width : '20%'
            },
            tags: {
                title: 'Tags',
                width: '25%'
            }
        },
    });
    $('#InfographicTableContainer').jtable('load');
});