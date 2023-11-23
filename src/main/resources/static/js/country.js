let opration = 0;

$(document).ready(function () {
    $("#detailContains").css("display", "none");
    // when click the create button, show the detailContains
    $("#selCreate").on('click', function () {
        // clear all input
        $(':input', '#frmDetail')
            .not(':button, :submit, :reset, :hidden')
            .val(''); 
        // show the detailContains
        $("#detailContains").css("display", "block");
        // hide the queryContainer
        $("#queryContainer").css("display", "none");
    });

    // when click the update button, show the queryContainer
    $("#selUpdate, #selDelete").on('click', function () {
        // show the queryContainer
        $("#queryContainer").css("display", "block");
        // hide the detailContains
        $("#detailContains").css("display", "none");
        // set the form action for update
        $("#frmDetail").attr("action", "/UpdateCountry");
        
        if ($(this).attr("id") == "selUpdate") {
			opration = 2;
			
			$('#updateBtn').html('更新');
		} else {
			opration = 3;
			
			$('#updateBtn').html('删除');
		}
    });

    // when click the return button, hide the detailContains
    $("#returnBtn").on('click', function () {
        // show the queryContainer
        // $("#queryContainer").css("display", "block");
        // hide the detailContains
        $("#detailContains").css("display", "none");
    });


	// 更新button押下
    $("#queryBtn").on('click', function () {
        // use ajax to post data to controller
        // recived the data from controller with json
        // show the data in the detailContains
        $.ajax({
            type: "POST",
            url: "/country/getCountry",        //  <- controller function name
            data: $("#frmSearch").serialize(),
            dataType: 'json',
            success: function (data) {
                $("#detailContains").css("display", "block");
                // show the data in the detailContains
                $("#countryCodeInput").val(data.mstcountrycd);
                $("#countryNameInput").val(data.mstcountrynanme);
            },
            error: function (e) {
                alert("error");
            }
        });
		});
    
    // 登录按钮押下updateBtn
    $("#updateBtn").on('click', function () {          
        // use ajax to post data to controller
        // recived the data from controller with json
        // show the data in the detailContains
        if (opration == 2) {
			
			// 更新场合
			 $.ajax({
            type: "POST",
            url: "/country/updCountry",
            data: $("#frmDetail").serialize(),
            success: function (data) {
                alert("更新成功");
                
                window.location.href = "countrySelect";
            },
            error:function(){
				alert("更新失败");
			}
        });
        
		} else if(opration == 3) {
			
			// 删除场合
			 $.ajax({
            type: "POST",
            url: "/country/delCountry",
            data: $("#frmDetail").serialize(),
            success: function (data) {
                alert("删除成功");
                
                window.location.href = "countrySelect";
            },
            error:function(){
				alert("删除失败");
			}
        });
        
		} else {
			// 登录场合
			$.ajax({
            type: "POST",
            url: "/country/loginCountry",
            data: $("#frmDetail").serialize(),
            success: function (data) {
                alert("添加成功");
                
                window.location.href = "countrySelect";
            },
            error:function(){
				alert("添加失败");
			}
        });
			
		}
    });
    
});