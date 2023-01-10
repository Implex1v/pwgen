import { get, writable } from "svelte/store";

export function localArrayStore<T>(key: string) {
    const isBrowser = typeof window !== "undefined";
    const store = writable<Array<T>>([]);
    const { subscribe, set } = store;

    if (isBrowser) {
        set(JSON.parse(localStorage.getItem(key) ?? "[]"));
    }

    return {
        subscribe,
        set: (data: Array<T>) => {
            isBrowser && localStorage.setItem(key, JSON.stringify(data));
            set(data);
        },
        update: (cb: (data: Array<T>) => Array<T>) => {
            const updatedStore = cb(get(store));

            isBrowser && localStorage.setItem(key, JSON.stringify(updatedStore));
            set(updatedStore);
        },
    };
}
