$(document).ready(function () {
    $.validator.addMethod("confirmPassword",function (value) {
        var password2 = $("#exampleInputPassword1").val();
        if (value === password2) {
            return true;
        }
        else {
            return false;
        }
    },"神奇海螺说你两次密码输入不一致");
    $('#quickForm').validate({
        rules: {
            email: {
                required: true,
                email: true
            },
            nickname: {
                required: true,
                maxlength: 10
            },
            password: {
                required: true,
                minlength: 6
            },
            password2: {
                confirmPassword: true
            },
            terms: {
                required: true
            },
        },
        messages: {
            email: {
                required: "神奇海螺说你还没输入邮箱",
                email: "神奇海螺说你这根本就不是邮箱"
            },
            password: {
                required: "神奇海螺说你还没输入密码",
                minlength: "神奇海螺说你的密码太短了"
            },
            terms: "你竟敢不相信神奇海螺！！╰（‵□′）╯",
            nickname: {
                required: "神奇海螺不屑于与无名小卒交流",
                maxlength: "你取这么长名字神奇海螺记不住啊"
            },
            password2: {
                confirmPassword: "神奇海螺说你两次密码输入不一致"
            }

        },
        errorElement: 'span',
        errorPlacement: function (error, element) {
            error.addClass('invalid-feedback');
            element.closest('.form-group').append(error);
        },
        highlight: function (element, errorClass, validClass) {
            $(element).addClass('is-invalid');
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).removeClass('is-invalid');
        }
    });
});