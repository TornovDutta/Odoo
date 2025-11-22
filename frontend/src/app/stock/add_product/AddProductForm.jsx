"use client";
import React from "react";
import { useState } from "react";

const AddProductForm = () => {
  const [form, setForm] = useState({
    productName: "",
    sku: "",
    category: "",
    uom: "",
    lowStock: "",
  });
  const [errors, setErrors] = useState({});

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm((s) => ({ ...s, [name]: value }));
  };

  const validate = () => {
    const err = {};
    if (!form.productName.trim()) err.productName = "Product Name is required";
    if (!form.sku.trim()) err.sku = "SKU is required";
    if (form.lowStock === "" || Number.isNaN(Number(form.lowStock)))
      err.lowStock = "Low Stock Alert must be a number";
    return err;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const err = validate();
    setErrors(err);
    if (Object.keys(err).length === 0) {
      const payload = {
        productName: form.productName.trim(),
        sku: form.sku.trim(),
        category: form.category.trim(),
        uom: form.uom.trim(),
        lowStock: Number(form.lowStock),
      };
      console.log("Add product payload:", payload);
      // TODO: call backend API to save product
      // reset form after successful save:
      // setForm({ productName: "", sku: "", category: "", uom: "", lowStock: "" });
    }
  };

  return (
    <section className="text-gray-600 body-font relative">
      <div className="container px-5 py-8 mx-auto">
        <div className="flex flex-col text-center w-full mb-6">
          <h1 className="sm:text-3xl text-2xl font-medium title-font mb-2 text-gray-900">
            Add Product
          </h1>
        </div>

        <form
          onSubmit={handleSubmit}
          className="lg:w-1/2 md:w-2/3 mx-auto bg-white p-6 rounded shadow"
        >
          <div className="flex flex-wrap -m-2">
            <div className="p-2 w-full">
              <label
                htmlFor="productName"
                className="leading-7 text-sm text-gray-600"
              >
                Product Name
              </label>
              <input
                id="productName"
                name="productName"
                type="text"
                value={form.productName}
                onChange={handleChange}
                className="w-full bg-gray-100 bg-opacity-50 rounded border border-gray-300 focus:border-indigo-500 focus:bg-white text-base outline-none py-2 px-3"
              />
              {errors.productName && (
                <p className="text-red-500 text-sm mt-1">
                  {errors.productName}
                </p>
              )}
            </div>

            <div className="p-2 w-full">
              <label htmlFor="sku" className="leading-7 text-sm text-gray-600">
                SKU
              </label>
              <input
                id="sku"
                name="sku"
                type="text"
                value={form.sku}
                onChange={handleChange}
                className="w-full bg-gray-100 bg-opacity-50 rounded border border-gray-300 focus:border-indigo-500 focus:bg-white text-base outline-none py-2 px-3"
              />
              {errors.sku && (
                <p className="text-red-500 text-sm mt-1">{errors.sku}</p>
              )}
            </div>

            <div className="p-2 w-1/2">
              <label
                htmlFor="category"
                className="leading-7 text-sm text-gray-600"
              >
                Category
              </label>
              <input
                id="category"
                name="category"
                type="text"
                value={form.category}
                onChange={handleChange}
                className="w-full bg-gray-100 bg-opacity-50 rounded border border-gray-300 focus:border-indigo-500 focus:bg-white text-base outline-none py-2 px-3"
              />
            </div>

            <div className="p-2 w-1/2">
              <label htmlFor="uom" className="leading-7 text-sm text-gray-600">
                UOM
              </label>
              <input
                id="uom"
                name="uom"
                type="text"
                value={form.uom}
                onChange={handleChange}
                className="w-full bg-gray-100 bg-opacity-50 rounded border border-gray-300 focus:border-indigo-500 focus:bg-white text-base outline-none py-2 px-3"
              />
            </div>

            <div className="p-2 w-full">
              <label
                htmlFor="lowStock"
                className="leading-7 text-sm text-gray-600"
              >
                Low Stock Alert
              </label>
              <input
                id="lowStock"
                name="lowStock"
                type="number"
                value={form.lowStock}
                onChange={handleChange}
                className="w-full bg-gray-100 bg-opacity-50 rounded border border-gray-300 focus:border-indigo-500 focus:bg-white text-base outline-none py-2 px-3"
              />
              {errors.lowStock && (
                <p className="text-red-500 text-sm mt-1">{errors.lowStock}</p>
              )}
            </div>

            <div className="p-2 w-full">
              <button
                type="submit"
                className="flex mx-auto text-white bg-indigo-500 border-0 py-2 px-8 rounded text-lg hover:bg-indigo-600"
              >
                Add Product
              </button>
            </div>
          </div>
        </form>
      </div>
    </section>
  );
};

export default AddProductForm;
