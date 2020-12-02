$(document).ready( function () {
    const table = $('#patienttable').DataTable({
        "sAjaxSource": "/test",
        "sAjaxDataProp": "",
        "order": [[0, "asc"]],
        "aoColumns": [
            {"mData": "id"},
            {"mData": "lastName"},
            {"mData": "firstName"},
            {"mData": "dateOfBirth"},
            {"mData": "nextOfKin"},
            {"mData": "phoneNumber"},
            {"mData": "gender"},
            {"mData": "age"},
            {"mData": "bloodGroup"},
            {"mData": "department"},
            {"mData": "doctorsName"},
            {"mData": "complains"},
            {"mData": "appointmentDate"},
            {"mData": "createdBy"},
            {"mData": "createdDate"},
            {"mData": "modifiedBy"},
            {"mData": "modifiedDate"},
            {"mData": "add"},
            {"mData": "edit"},
            {"mData": "delete"}
        ]
    });
});