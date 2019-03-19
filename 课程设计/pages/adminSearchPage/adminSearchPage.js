// pages/adminSearchPage/adminSearchPage.js

// var page = 0;

// var GetDataList = function (that) {

//   console.log("----------------->>>>" + page);

//   that.setData({
//     hidden: false
//   });
//   wx.request({
//     url: "http://localhost:8082/weixin/superadmin/listemployee",
//     data: {
//       page: page,
//     },
//     success: function (res) {

//       var dataArray = that.data.list;
//       console.log("----" + dataArray);
//       for (var i = 0; i < res.data.length; i++) {
//         dataArray.push(res.data.data[i])
//       }

//       that.setData({
//         dataList: dataArray,
//       })

//       page++;
//       that.setData({
//         hidden: true
//       });

//     }
//   });

// }

Page({

  /**
   * 页面的初始数据
   */
  data: {
    list:[]
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
    var that = this;
    wx.request({
      url: 'http://localhost:8082/weixin/superadmin/listemployee',
      method: 'GET',
      data:{},
      success: function(res) {
        var list = res.data.employeeList;
        if(list == null){
          var toastText = '获取数据失败' + res.data.errMsg;
          wx.showToast({
            title: toastText,
            icon:'',
            duration:2000
          });
        } else{
          that.setData({
            list: list
          })
        }
      }
    })
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

  toMessage:function (e) {
    var employeeId = this.data.list[e.currentTarget.dataset.index].employeeId;
    wx.navigateTo({
      url: '../employeeMessage/employeeMessage?employeeId=' + employeeId,
    })
    console.log("employeeId:" + employeeId);
  },

  deleteEmployee: function (e) {
    var employeeId = this.data.list[e.currentTarget.dataset.index].employeeId;
    wx.showModal({
      title: '删除该用户',
      content: '',
      confirmColor: '#4E97F7',
      success:function (res) {
        if(res.confirm){
          console.log("用户点击确定");
          wx.request({
            url: 'http://localhost:8082/weixin/superadmin/removeemployee',
            data: {
              employeeId: employeeId
            },
            success: function () {
              console.log("删除成功！");
              wx.showToast({
                title: '删除成功！',
                duration: 0,
                mask: true,
                success: function (res) { },
                fail: function (res) { },
                complete: function (res) { },
              })
            },
            fail: function () {
              console.log("删除失败！");
              wx.showToast({
                title: '删除失败！',
                duration: 0,
                mask: true,
                success: function (res) { },
                fail: function (res) { },
                complete: function (res) { },
              })

            },
          })
          wx.request({
            url: 'http://localhost:8082/weixin/logon/removelogon',
            data: {
              employeeId: employeeId
            }
          })
        }
        else if(res.cancel){
          console.log("用户点击取消");
        }
      }
    })
  },

  //添加新用户
  addUser: function () {
    wx.navigateTo({
      url: '../addUser/addUser',
    })
  },

  searchButton: function (e) {
    wx.navigateTo({
      url: '../searchPage/searchPage'
    })
  },

  toMobilize: function () {
    wx.navigateTo({
      url: '../adminMobilizePage/adminMobilizePage'
    })
  }

})