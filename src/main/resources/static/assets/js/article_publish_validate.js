$(document).ready(function () {
    $('#quickForm').validate({
        rules: {
            title: {
                required: true
            },
            keywords: {
                required: true
            },
            content: {
                required: true
            },
            terms: {
                required: true
            }
        },
        messages: {
            title: {
                required: "神奇海螺说你还没输入标题",
            },
            keywords: {
                required: "没有关键字神奇海螺可搜不到你的文章哦"
            },
            content: {
                required: "神奇海螺说你还没输入正文",
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