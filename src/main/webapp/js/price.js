function price(obj,suffix,property_id) {

    var name	=$(obj).attr('id');
    var property = $(obj).find("input").val();
    var name1=$(obj).find("input").attr("name")
    $("li[id='"+name+"']").attr('class','');
    $(obj).attr('class','selected');
    $("#property_"+name1).val(property);
    //自动下一步
    auto_go_next(obj);



}
function price_1 () {
    var flag	=	true;
    $("#property_step1 input").each(function(){if($(this).val()==0){flag=false;return false;}});
    if(!flag){
        alert('请选择评估参数');
        return false;
    }

    $("#property_step2").show();
    $("#property_step1").hide();
    $("#speed2").show();
    $("#speed1").hide();

}
function price_2(){
    $("#property_step3").show();
    $("#property_step2").hide();
    $("#speed3").show();
    $("#speed2").hide();
}
function	price_3(obj,suffix){
    var name			=	$(obj).attr('name');
    var current_class	=	$(obj).attr('class');
    var name1=$(obj).find("input").attr("name")
    var property = $(obj).find("input").val();
    if(current_class	==	'selected'){
        $(obj).attr('class','');
        $("#desc_id_"+name1).val(0);
    }else {
        $(obj).attr('class','selected');
        $("#desc_id_"+name1).val(property);
    }
}