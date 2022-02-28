const Confirm = {
    show: function (message, callback) {
        Swal.fire({
            title: '确认删除?',
            text: message,
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: '确认删除!'
        }).then((result) => {
            if (callback) {
                callback()
            }
        })

    }
}