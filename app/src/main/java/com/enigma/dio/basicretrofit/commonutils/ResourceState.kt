package com.enigma.dio.basicretrofit.commonutils

class ResourceState(val resourceStatus: ResourceStatus, val data : Any?, val message : Any?) {

    companion object {
        fun success(data : Any?) : ResourceState {
            return ResourceState(
                resourceStatus = ResourceStatus.SUCCESS,
                data = data,
                message = null
            )
        }

        fun failure(message : Any?) : ResourceState {
            return ResourceState(
                resourceStatus = ResourceStatus.FAILURE,
                data = null,
                message = message
            )
        }
        fun loading() : ResourceState{
            return ResourceState(
                resourceStatus = ResourceStatus.LOADING,
                data = null,
                message = null
            )
        }
    }
}