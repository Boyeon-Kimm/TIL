<template>
  <div class="home">
    <img src="@/assets/ssafy_logo.png" />
    <h2>게시판 환영!</h2>
    <hr>
    <b-icon icon="camera"></b-icon>
    <b-icon icon="camera" rotate="45"></b-icon>
    <b-icon icon="camera" rotate="90"></b-icon>
    <b-icon icon="camera" rotate="180"></b-icon>
    <b-icon icon="camera" rotate="270"></b-icon>
    <b-icon icon="camera" rotate="-45" animation="spin"></b-icon>
     <b-iconstack font-scale="5">
      <b-icon stacked icon="camera" variant="info" scale="0.75"></b-icon>
      <b-icon stacked icon="slash-circle" variant="danger"></b-icon>
    </b-iconstack>
  </div>
</template>

<script>
export default {
  name: 'HomeView',
};
</script>
