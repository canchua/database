// pages/addUser/addUser.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    employeeId: 0,
    employeeName: '',
    authority: 0,
    password: '',
    job: '',
    employeeState: '',
    joinTime: '',
    departmentId: ''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  formSubmit: function (e) {
    var that = this;
    // var employee = e.detail.value;
    console.log("e.detail.value: " + e.detail.value);
    console.log("e.detail.value.employeeId: " + e.detail.value.employeeId);
    console.log("e.detail.value.employeeName: " + e.detail.value.employeeName);
    console.log("e.detail.value.authority: " + e.detail.value.authority);
    console.log("e.detail.value.password: " + e.detail.value.password);
    console.log("e.detail.value.job: " + e.detail.value.job);
    console.log("e.detail.value.employeeState: " + e.detail.value.employeeState);
    console.log("e.detail.value.joinTime: " + e.detail.value.joinTime);
    console.log("e.detail.value.departmentId: " + e.detail.value.departmentId);
    that.setData({
      employeeId: e.detail.value.employeeId,
      employeeName: e.detail.value.employeeName,
      authority: e.detail.value.authority,
      password: e.detail.value.password,
      job: e.detail.value.job,
      employeeState: e.detail.value.employeeState,
      joinTime: e.detail.value.joinTime,
      departmentId: e.detail.value.departmentId
    })
    wx.request({
      url: 'http://localhost:8082/weixin/superadmin/addemployee',
      data:{
        employeeId: e.detail.value.employeeId,
        employeeName: e.detail.value.employeeName,
        job: e.detail.value.job,
        employeeState: e.detail.value.employeeState,
        joinTime: e.detail.value.joinTime,
        departmentId: e.detail.value.departmentId
        // employee: e.detail.value
      },
      method: 'POST',
      header: {
        'content-type': 'application/json'
      },
      success:function (res){
        console.log("新员工添加成功！");
        wx.showToast({
          title: '新员工添加成功！',
          duration: 0,
          mask: true,
          success: function (res) { },
          fail: function (res) { },
          complete: function (res) { },
        })
        wx.navigateBack({
        })
      },
      fail: function () {
        console.log("新员工添加失败！");
        wx.showToast({
          title: '新员工添加失败！',
          duration: 0,
          mask: true,
          success: function (res) { },
          fail: function (res) { },
          complete: function (res) { },
        })

      },
    })

    wx.request({
      url: 'http://localhost:8082/weixin/logon/addlogon',
      data: {
        employeeId: e.detail.value.employeeId,
        authority: e.detail.value.authority,
        password: e.detail.value.password
      },
      method: 'POST',
      header: {
        'content-type': 'application/json'
      },
    })
  }

})