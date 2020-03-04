$(document).ready(function () {
    $('#quickForm').validate({
        rules: {
            email: {
                required: true,
                email: true,
            },
            password: {
                required: true,
                minlength: 5
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
            terms: "你竟敢不相信神奇海螺！！╰（‵□′）╯"
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