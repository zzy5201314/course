<template>
  <div>
    <p>
      <!-- Button trigger modal -->
      <button @click="add()" class="btn btn-white btn-default btn-round">
        <i class="ace-icon fa fa-edit"></i>
        新增
      </button>
      <!--      加入一个空格-->
      &nbsp;

      <button @click="list(1)" class="btn btn-white btn-default btn-round">
        <i class="ace-icon fa fa-refresh"></i>
        刷新
      </button>
    </p>

    <pagination ref="pagination" v-bind:list="list" v-bind:item-count="8"></pagination>

    <table id="simple-table" class="table  table-bordered table-hover">
      <thead>
      <tr>
        <th>ID</th>
        <th>名称</th>
        <th>课程ID</th>
        <th>操作</th>
      </tr>
      </thead>

      <tbody>
      <tr v-for="chapter in chapters" :key="chapter.id">
        <td>{{ chapter.id }}</td>
        <td>{{ chapter.name }}</td>
        <td>{{ chapter.courseId }}</td>
        <td>
          <div class="hidden-sm hidden-xs btn-group">

            <button @click="edit(chapter)" class="btn btn-xs btn-info">
              <i class="ace-icon fa fa-pencil bigger-120"></i>
            </button>

            <button @click="del(chapter.id)" class="btn btn-xs btn-danger">
              <i class="ace-icon fa fa-trash-o bigger-120"></i>
            </button>

          </div>
        </td>
      </tr>
      </tbody>
    </table>


    <!-- Modal -->
    <div id="form-modal" class="modal fade" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                aria-hidden="true">&times;</span></button>
            <h4 class="modal-title">表单</h4>
          </div>
          <div class="modal-body">
            <form class="form-horizontal">

              <div class="form-group">
                <label class="col-sm-2 control-label">名称</label>
                <div class="col-sm-10">
                  <input v-model="chapter.name" class="form-control" placeholder="名称">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">课程ID</label>
                <div class="col-sm-10">
                  <input v-model="chapter.courseId" class="form-control" placeholder="课程ID">
                </div>
              </div>

            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button @click="save()" type="button" class="btn btn-primary">保存</button>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>


<script>
import Pagination from "@/components/pagination";

export default {
  name: 'chapter',
  components: {
    Pagination
  },
  data: function () {
    return {
      chapter: {},
      chapters: []
    }
  },
  mounted() {
    let _this = this;
    _this.$refs.pagination.size = 5;
    _this.list(1);
    // this.$parent.activeSideBar("business-chapter-sidebar");
  },
  methods: {
    add() {
      let _this = this;
      _this.chapter = {};
      $("#form-modal").modal("show");
    },

    edit(chapter) {
      let _this = this;
      _this.chapter = $.extend({}, chapter);
      $("#form-modal").modal("show");
    },

    del(id) {
      let _this = this;
      Confirm.show("删除后不可恢复，请确认是否删除!", function () {
        Loading.show();
        _this.$ajax.delete("http://127.0.0.1:9000/business/admin/chapter/delete/" + id).then((response) => {
          console.log("删除大章列表结果:", response);
          let resp = response.data;
          if (resp.success) {
            Loading.hide();
            _this.list(1);
            Toast.success("删除成功！");
          }
        });
      })
    },

    list(page) {
      let _this = this;
      Loading.show();
      _this.$ajax.post("http://127.0.0.1:9000/business/admin/chapter/list", {
        page: page,
        size: _this.$refs.pagination.size,
      }).then((response) => {
        Loading.hide();
        let resp = response.data;
        console.log("查询大章列表结果:", response);
        _this.chapters = resp.content.list;
        _this.$refs.pagination.render(page, resp.content.total);
      })
    },

    save(page) {
      let _this = this;

      // 保存校验
      if ((!Validator.require(_this.chapter.name, "名称"))
          || (!Validator.require(_this.chapter.courseId, "课程ID"))
              || (!Validator.length(_this.chapter.courseId, "课程ID",1,8))){
          return ;
      }

      Loading.show();
      _this.$ajax.post("http://127.0.0.1:9000/business/admin/chapter/save", _this.chapter).then((response) => {
        let resp = response.data;
        if (resp.success) {
          Loading.hide();
          $("#form-modal").modal("hide");
          _this.list(1);
          Toast.success("保存成功！");
        } else {
          Toast.warning(resp.message);
          Loading.hide();
        }
      })
    }
  }

}
</script>

<style scoped>

</style>