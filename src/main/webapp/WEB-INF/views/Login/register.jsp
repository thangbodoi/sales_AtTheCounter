
<section class="h-100">
    <div class="container h-100">
        <div class="row justify-content-sm-center h-100">
            <div class="col-xxl-4 col-xl-5 col-lg-5 col-md-7 col-sm-9">
                <div class="text-center my-5">
                    <img
                            src="https://getbootstrap.com/docs/5.0/assets/brand/bootstrap-logo.svg"
                            alt="logo"
                            width="100"
                    />
                </div>
                <div class="card shadow-lg">
                    <div class="card-body p-5">
                        <h1 class="fs-4 card-title fw-bold mb-4">Register</h1>
                        <form
                                method="POST"
                                class="needs-validation"
                                novalidate=""
                                name="form1"
                                autocomplete="off"
                        >
                            <div class="mb-3">
                                <label class="mb-2 text-muted" for="name">Name</label>
                                <input
                                        id="name"
                                        type="text"
                                        class="form-control"
                                        name="name"
                                        ng-model="form_user.name"
                                        required
                                        autofocus
                                />
                                <p class="txtError" ng-hide="form1.name.$valid">
                                    Họ Tên không được để trống
                                </p>
                                <div class="invalid-feedback">Name is required</div>
                            </div>

                            <div class="mb-3">
                                <label class="mb-2 text-muted" for="email"
                                >E-Mail Address</label
                                >
                                <input
                                        id="email"
                                        type="email"
                                        class="form-control"
                                        ng-model="form_user.email"
                                        name="email11"
                                        required
                                />
                                <p class="txtError" ng-hide="form1.email11.$valid">
                                    Email không được để trống và phải đúng định dạng!
                                </p>
                                <div class="invalid-feedback">Email is invalid</div>
                            </div>

                            <div class="mb-3">
                                <label class="mb-2 text-muted" for="password">Password</label>
                                <input
                                        id="password"
                                        ng-model="form_user.password"
                                        type="password"
                                        class="form-control"
                                        name="password"
                                        required
                                />
                                <p class="txtError" ng-hide="form1.password.$valid">
                                    Mật khẩu không được để trống!
                                </p>
                                <div class="invalid-feedback">Password is required</div>
                            </div>

                            <p class="form-text text-muted mb-3">
                                By registering you agree with our terms and condition.
                            </p>

                            <div class="align-items-center d-flex">
                                <button
                                        ng-click="createUser($event)"
                                        type="submit"
                                        class="btn btn-primary ms-auto"
                                >
                                    Register
                                </button>
                            </div>
                        </form>
                    </div>
                    <div class="card-footer py-3 border-0">
                        <div class="text-center">
                            Already have an account?
                            <a href="#login" class="text-dark">Login</a>
                        </div>
                    </div>
                </div>
                <div class="text-center mt-5 text-muted">
                    Copyright &copy; 2017-2021 &mdash; Your Company
                </div>
            </div>
        </div>
    </div>
</section>


