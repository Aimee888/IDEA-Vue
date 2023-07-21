<script>
export default {
  name: 'HeaderPage',
  data() {
    return {
      user_name: this.$route.query.param
    }
  }
}

</script>

<template>
  <div>
    <div class="head">
      <div>
        <span>123{{user_name}}</span>
      </div>
    </div>
    <div class="line" />
  </div>
</template>

<style scoped>
.head {
  display: flex;
  align-items: center;
  justify-content: right;
  height: 50px;
  background-color: #222832;
}
.head > div {
  display: flex;
  align-items: center;
  margin-right: 20px;
}
.head span {
  font-size: 15px;
  color: #ffffff;
}
.line {
  border-top: 1px solid hsla(0,0%,100%,.05);
  border-bottom: 1px solid rgba(0,0,0,.2);
}
</style>
