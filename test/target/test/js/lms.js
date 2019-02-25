formatDate=function  (value) {
    if (value == undefined) {
        return '';
    }
    var dateMat = new Date(value);
    var year = dateMat.getFullYear();
    var month = dateMat.getMonth() + 1;
    var day = dateMat.getDate();
    return  year + '-' + month + '-' + day;
}